window.addEventListener('load', function () {
    const signupForm = document.querySelector('#signup-form');
    signupForm.style.opacity = 0;
    setTimeout(() => {
        signupForm.style.transition = 'opacity 1s ease-in-out';
        signupForm.style.opacity = 1;
    }, 500);

    signupForm.addEventListener('submit', function (event) {
        const emailInput = document.querySelector('input[type="email"]');
        const passwordInput = document.querySelector('input[type="password"]#password');
        const confirmPasswordInput = document.querySelector('input[type="password"]#passwordcon');

        let errorMessage = document.getElementById('error-message');
        if (errorMessage) {
            errorMessage.remove();
        }

        const error = document.createElement('p');
        error.id = 'error-message';
        error.style.color = 'red';

        if (!emailInput.checkValidity()) {
            error.innerText = 'Por favor, insira um email válido.';
            emailInput.parentElement.appendChild(error);
            event.preventDefault();
            return;
        }

        if (passwordInput.value !== confirmPasswordInput.value) {
            error.innerText = 'As senhas não coincidem!';
            confirmPasswordInput.parentElement.appendChild(error);
            event.preventDefault();
            return;
        }
    });
});
