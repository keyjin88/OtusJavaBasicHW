/**
 * Функция для обработки введенных значений
 */
function getDataTable() {
    const table = document.getElementById("studentsTable").getElementsByTagName("tbody")[0];
    const name = document.getElementById("nameInput").value;
    const gender = document.getElementById("genderSelect").value;
    const birthsDayInputValue = document.getElementById("birthsDayInput").value;
    const transformedBornDate = birthsDayInputValue.split('-').reverse().join('.');
    const ageCount = calculateAgeCount(birthsDayInputValue);
    console.log(ageCount, name, gender, birthsDayInputValue)

    if (name) {
        if (name.length < 5 || name.length > 50) {
            alert("Введено некорректное имя!")
        } else {
            let inputParams = [name, gender, transformedBornDate, ageCount];
            addNewRow(table, inputParams);
        }
    } else {
        alert("Имя нужно обязательно заполнить!");
    }
    calculateAverage();
}

/**
 *
 * Функция для создания новой строки в таблице студентов
 *
 * @param table - таблица студентов
 * @param params - массив с данными студента
 */
function addNewRow(table, params) {
    const newRow = table.insertRow(-1);
    for (let i = 0; i < 4; i++) {
        const newCell = document.createElement("td");
        if (i === 3) {
            newCell.style.textAlign = 'right';
            newCell.classList.add("ageColumn")
        }
        newCell.innerHTML = params[i];
        newRow.appendChild(newCell);
    }
}

/**
 * Функция для расчета возраста студента по дате рождения
 * @param dateString - дата в формате YYYY-DD-MM
 * @returns {number} - количество полных лет
 */
function calculateAgeCount(dateString) {
    const birthDay = new Date(dateString);
    const age = Math.floor((new Date() - new Date(birthDay)) / 1000 / 60 / 60 / 24 / 365);
    if (age < 0 || age > 100) {
        alert("Введите корректную дату!")
        return 0;
    } else {
        return age;
    }
}

/**
 * Функция для подсчета среднего возраста студента
 */
function calculateAverage() {
    const classes = document.getElementsByClassName("ageColumn");
    let sum = 0;
    if (classes.length > 0) {
        for (let i = 0; i < classes.length; i++) {
            sum += Number(classes[i].innerHTML);
        }
    }
    let average = Math.floor(sum / classes.length);
    const targetCell = document.getElementById("averageAgeTitle");
    targetCell.innerHTML = average.toString();
}