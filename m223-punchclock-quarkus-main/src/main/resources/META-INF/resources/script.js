const URL = 'http://localhost:8080';
let entries = [];

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};

const createUser = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const user = {};
    user['name'] = formData.get('name');
    user['vorname'] = formData.get('vorname');
    user['mail'] = formData.get('mail');
    user['passwort'] = formData.get('passwort');
    fetch(`${URL}/users`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then((result) => {
        result.json().then((user) => {
            entries.push(user);
            renderUsers();
        });
    });
};

const renderUsers = () => {
    const display = document.querySelector('#userDisplay');
    display.innerHTML = '';
    entries.forEach((user) => {
        const row = document.createElement('tr');
        const button = document.createElement('button');
        button.innerHTML = "Delete";
        button.id = user.id;
        button.onclick = function () {deleteEntry(this.id)}
        row.appendChild(createCell(user.id));
        row.appendChild(createCell(new Date(user.checkIn).toLocaleString()));
        row.appendChild(createCell(new Date(user.checkOut).toLocaleString()));
        row.appendChild(button);
        display.appendChild(row);
    });
};

const indexUsers = () => {
    fetch(`${URL}/users`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            users = result;
            renderUsers();
        });
    });
    renderUsers();
};

function deleteUser(id){
    const response = fetch(`${URL}/users/${id}`, {
        method: 'DELETE',
    }).then((result) => {
        indexUsers();
    })
}

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

document.addEventListener('DOMContentLoaded', function(){
    const createUserForm = document.querySelector('#createUserForm');
    createUserForm.addEventListener('submit', createUser);
    indexUsers();
});