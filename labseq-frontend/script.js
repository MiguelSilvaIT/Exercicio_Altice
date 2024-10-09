document.getElementById('calculateButton').addEventListener('click', async function() {
    const indexInput = document.getElementById('indexInput');
    const resultsContainer = document.getElementById('resultsContainer');
    const resultsList = document.getElementById('resultsList');
    const errorContainer = document.getElementById('errorContainer');
    const errorMessage = document.getElementById('errorMessage');

    // Função para limpar resultados e mensagens de erro
    const clearResults = () => {
        resultsList.innerHTML = '';
        resultsContainer.style.display = 'none';
        errorContainer.style.display = 'none';
        errorMessage.innerText = '';
    };

    // Função para exibir uma mensagem de erro
    const showError = (message) => {
        errorMessage.innerText = message;
        errorContainer.style.display = 'block';
    };

    // Valida uma string de números separados por vírgulas
    const parseAndValidateNumbers = (input) => {
        const numbers = input.split(',').map(num => num.trim());
        const isValid = numbers.every(num => !isNaN(num) && Number.isInteger(parseFloat(num)) && num >= 0);
        return isValid ? numbers : null;
    };

    // Limpa resultados anteriores e prepara a entrada do utilizador
    clearResults();
    const input = indexInput.value.trim();

    // Verifica se a entrada está vazia
    if (!input) {
        showError("Please enter a valid sequence of non-negative integers.");
        return;
    }

    // Valida e extrai a sequência de números
    const numbers = parseAndValidateNumbers(input);
    if (!numbers) {
        showError("Please enter only non-negative integers, separated by commas.");
        return;
    }

    resultsContainer.style.display = 'block';

    // Processa cada número individualmente e exibe o resultado
    for (let n of numbers) {
        try {
            const result = await fetchResult(n);
            displayResult(`l(${n}) = ${result}`);
        } catch (error) {
            displayResult(`Error fetching result for ${n}: ${error.message}`, true);
        }
    }
});

// Função auxiliar para obter o resultado do backend
async function fetchResult(n) {
    const response = await fetch(`http://localhost:8080/labseq/${n}`);
    if (!response.ok) {
        throw new Error("Failed to fetch result.");
    }
    return response.text();
}

// Função auxiliar para exibir resultados ou erros na lista
function displayResult(message, isError = false) {
    const resultsList = document.getElementById('resultsList');
    const listItem = document.createElement('li');
    listItem.classList.add('list-group-item');
    if (isError) listItem.classList.add('text-danger');
    listItem.textContent = message;
    resultsList.appendChild(listItem);
}
