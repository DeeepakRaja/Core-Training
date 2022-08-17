todoList = [];
count = 1;
function getTodos() {
    url = 'https://jsonplaceholder.typicode.com/todos';
    fetch(url).then(response => response.json()).then(json => todoList = json);
}

function addTodo() {
    userid = document.getElementById('userId').value;
    id = document.getElementById('todoID').value;
    title = document.getElementById('task').value;
    completed = false;
    todo = {
        userId: userid,
        id: id,
        title: title,
        completed: completed
    }
    url = "https://jsonplaceholder.typicode.com/todos"
    fetch(url,
        {
            method: "POST",
            body: JSON.stringify(todo),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        })
        .then(response => response.json())
        .then(json => { document.getElementById('display').innerHTML = 'ToDo added successfully'; json.id = todoList.length + 1; todoList.unshift(json) })
        .catch(reason => console.log(reason))

    document.getElementById('userId').value = '';
    document.getElementById('todoID').value = '';
    document.getElementById('task').value = '';
}

function updateTodo() {
    userid = document.getElementById('userId').value;
    id = document.getElementById('todoID').value;
    title = document.getElementById('task').value;

    todoList.forEach(todo => {
        if (id == todo.id) {
            todo.userId = userid;
            todo.title = title;
        }
    });
    document.getElementById('userId').value = '';
    document.getElementById('todoID').value = '';
    document.getElementById('task').value = '';
    document.getElementById('display').innerHTML = 'ToDo updated successfully';
}

function searchTask() {
    data = '<tr><th>User ID</th><th>ID</th><th>Title</th><th>Completed</th><th>Delete</th><th>Update</th></tr>';
    task = document.getElementById('search').value;
    flag = 0;
    todoList.forEach(todo => {
        if (task == todo.title) {
            data += `<tr><td>${todo.userId}</td><td>${todo.id}</td><td>${todo.title}</td><td>${todo.completed}</td>
            <td><input type="checkbox" name="cbox" id="cbox" onclick="removeTask(${todo.id})"></td>
            <td><input type="button" value="Update" id="updateList" onclick="populate(${todo.id})"></td>
            </tr>`;
            document.getElementById('display').innerHTML = data;
            flag = 1;
        }
    });
    if (flag == 0) document.getElementById('display').innerHTML = 'No Results !';
}

function displayData() {
    data = '<tr><th>User ID</th><th>ID</th><th>Title</th><th>Completed</th><th>Delete</th><th>Update</th></tr>';
    for (todo of todoList) {
        data += `<tr>
                    <td>${todo.userId}</td><td>${todo.id}</td><td>${todo.title}</td><td>${todo.completed}</td>
                    <td><input type="checkbox" name="cbox" id="cbox" onclick="removeTask(${todo.id})"></td>
                    <td><input type="button" value="Update" id="updateList" onclick="populate(${todo.id})"></td>
                    </tr>`
    }
    document.getElementById('display').innerHTML = data;
}
function populate(id) {
    tempTask = todoList.find(todo => id == todo.id);
    document.getElementById('userId').value = tempTask.userId;
    document.getElementById('todoID').value = tempTask.id;
    document.getElementById('task').value = tempTask.title;
}

function removeTask(id) {
    todoList = todoList.filter(todo => todo.id != id);
    displayData();
}