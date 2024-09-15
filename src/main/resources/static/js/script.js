document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    form.addEventListener('submit', function(event) {
        const salaryInput = document.getElementById('salary');
        const salaryValue = parseFloat(salaryInput.value);

        if (isNaN(salaryValue) || salaryValue <= 0) {
            alert('Please enter a valid salary.');
            event.preventDefault();  // Prevent the form from submitting
        }
    });
});
