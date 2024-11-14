window.addEventListener('load', function () {
    const signupForm = document.querySelector('section');
    signupForm.style.opacity = 0;
    setTimeout(() => {
        signupForm.style.transition = 'opacity 1s ease-in-out';
        signupForm.style.opacity = 1;
    }, 500);

    const signupButton = document.querySelector('button');
    signupButton.addEventListener('click', function (event) {
        const emailInput = document.querySelector('input[type="email"]');
        const passwordInput = document.querySelector('input[type="password"]#password');
        const confirmPasswordInput = document.querySelector('input[type="password"]#passwordcon');

        // Limpa mensagens de erro antigas
        let errorMessage = document.getElementById('error-message');
        if (errorMessage) {
            errorMessage.remove();
        }

        // Cria um elemento para exibir a mensagem de erro, se necessário
        const error = document.createElement('p');
        error.id = 'error-message';
        error.style.color = 'red';

        // Valida se o email é válido
        if (!emailInput.checkValidity()) {
            error.innerText = 'Por favor, insira um email válido.';
            emailInput.parentElement.appendChild(error);
            signupForm.classList.add('shake');
            setTimeout(() => {
                signupForm.classList.remove('shake');
            }, 1000);
            event.preventDefault();
            return;
        }

        // Verifica se a senha e a confirmação de senha coincidem
        if (passwordInput.value !== confirmPasswordInput.value) {
            error.innerText = 'As senhas não coincidem!';
            confirmPasswordInput.parentElement.appendChild(error);
            signupForm.classList.add('shake');
            setTimeout(() => {
                signupForm.classList.remove('shake');
            }, 1000);
            event.preventDefault();
            return;
        }
    });
});
