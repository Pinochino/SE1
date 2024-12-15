'use strict'
window.addEventListener('DOMContentLoaded', init);

(function init() {
    function getCompanies() {
        const api = `http://localhost:8080/company/list`;
        fetch(api)
            .then(res => statusCheck(res))
            .then(data => data.json())
            .then(data => displayData(data))
            .catch(error => handleError(error))
    }

    async function statusCheck(response) {
        if (!response.ok) {
            throw new Error(await JSON.parse(response))
        }
        return response;
    }

    function displayData(data) {
        const companies = document.getElementById('selectCompany');
        const option = gen('option');
        option.innerHTML = ''

        Array.from(data).map((el) => {
            option.innerHTML = el;
            option.value = el;
            companies.appendChild(data);
        })
    }

    function handleError(error) {
        return error;
    }
})();


function id(params) {
    return document.getElementById(params)
}

function qs(params) {
    return document.querySelector(params)
}

function qsa(params) {
    return document.querySelectorAll(params);
}

function gen(params) {
    return document.createElement(params);
}