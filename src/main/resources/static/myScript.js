
const url = 'http://localhost:8080/api/user/'
const urlRole = 'http://localhost:8080/api/role/'
const urlPrincipal = 'http://localhost:8080/api/principal/'
const allUsers = fetch(url).then(response => response.json())
const allRoles = fetch(urlRole).then(response => response.json())
const principal = fetch(urlPrincipal).then(response => response.json())

const navBar = document.getElementById('navbar')

//Заполнение navBar
principal.then(user => {
    let usersRoles = ''
    let count = 0;
    user.roles.forEach(role => {
        count++
        if (count == 2) {
            usersRoles += ' and ' + role.name.replace('ROLE_', '')
        } else {
            usersRoles += role.name.replace('ROLE_', '') + ' '
        }
    })
    navBar.innerHTML = `${user.username} with roles: ${usersRoles}`
})

