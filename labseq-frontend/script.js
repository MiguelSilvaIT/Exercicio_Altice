document.getElementById('calculateButton').addEventListener('click', function() {
    const indexInput = document.getElementById('indexInput');
    const resultContainer = document.getElementById('resultContainer');
    const result = document.getElementById('result');
    const errorContainer = document.getElementById('errorContainer');
    const errorMessage = document.getElementById('errorMessage');

    // Limpa os resultados anteriores
    resultContainer.style.display = 'none';
    errorContainer.style.display = 'none';

    const n = indexInput.value;

    // Verifica se o valor de entrada é um número inteiro não negativo
    if (n === '' || isNaN(n) || n < 0 || !Number.isInteger(parseFloat(n))) {
        errorMessage.innerText = "Please enter a valid non-negative integer.";
        errorContainer.style.display = 'block';
        return;
    }

    // Chama o endpoint do backend
    fetch(`http://localhost:8080/labseq/${n}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch result. Please check your input.");
            }
            return response.text();
        })
        .then(data => {
            result.innerText = data;
            resultContainer.style.display = 'block';
        })
        .catch(error => {
            errorMessage.innerText = error.message;
            errorContainer.style.display = 'block';
        });
});
