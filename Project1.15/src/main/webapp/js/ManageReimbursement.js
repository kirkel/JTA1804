// window.onload = function () {
//     document.getElementById("getRequests").addEventListener("click", getRequests);
//     getRequests();
// }

// window.click = function () {
//     document.getElementById("getIdRequests").addEventListener("click", getIdRequests);
//     getIdRequests();
// }

window.onload = function () {
    // document.getElementById("getEmployees").addEventListener("click", getEmployees);
    getEmployees();
}

function getRequests() {

    // Step 1: create the XMLHttpRequest Object
    let xhr = new XMLHttpRequest();

    // Step 2: Define the onreadystatechange callback function
    xhr.onreadystatechange = function () {
        // Step 5: handle the response
        //console.log(xhr.responseText);
        //console.log(xhr.status);
        if (xhr.readyState === 4 && xhr.status === 200) {

            // Delete the old table body
            let new_tbody = document.createElement("tbody");
            document.getElementById("requestsTable").innerHTML = "";

            let requests = JSON.parse(xhr.responseText);

            let status1 = document.getElementById("statusSelect").value;
            //console.log(status);

            // document.getElementById("eid").value == request.requesterId &&
            for (let request of requests) {

                if ((status1 === "all" || status1 === request.status)) {
                    // Create all the necessary categories
                    let rId = request.rId;
                    let requesterId = request.requesterId;
                    let status = request.status;
                    if (status === "pending") {
                        status = "Pending";
                    }
                    ;
                    if (status === "accepted") {
                        status = "Accepted";
                    }
                    ;
                    if (status === "denied") {
                        status = "Denied";
                    }
                    ;
                    let category = request.category;
                    if (category === "food") {
                        category = "Food";
                    }
                    ;
                    if (category === "lodging") {
                        category = "Lodging";
                    }
                    ;
                    if (category === "travel") {
                        category = "Travel";
                    }
                    ;
                    if (category === "other") {
                        category = "Other";
                    }
                    ;
                    let amount = request.reimbursementAmount;
                    let submitDate = request.submitDate;
                    let submitComment = request.submitComment;
                    let resolveDate = request.resolveDate;
                    let resolveComment = request.resolveComment;

                    // Dynamically create the HTML tags

                    let row = document.createElement("tr");
                    let tdrId = document.createElement("td");
                    let tdRequesterId = document.createElement("td");
                    let tdStatus = document.createElement("td");
                    let tdCategory = document.createElement("td");
                    let tdAmount = document.createElement("td");
                    let tdSubmitDate = document.createElement("td");
                    let tdSubmitComment = document.createElement("td");
                    let tdResolveDate = document.createElement("td");
                    let tdResolveComment = document.createElement("td");

                    // We assign each td their corresponding value
                    tdrId.textContent = rId;
                    tdRequesterId.textContent = requesterId;
                    tdStatus.textContent = status;
                    tdCategory.textContent = category;
                    tdAmount.textContent = amount;
                    tdSubmitDate.textContent = submitDate;
                    tdSubmitComment.textContent = submitComment;
                    tdResolveDate.textContent = resolveDate;
                    tdResolveComment.textContent = resolveComment;

                    // We add each td to the tr
                    row.appendChild(tdrId);
                    row.appendChild(tdRequesterId);
                    row.appendChild(tdStatus);
                    row.appendChild(tdCategory);
                    row.appendChild(tdAmount);
                    row.appendChild(tdSubmitDate);
                    row.appendChild(tdSubmitComment);
                    row.appendChild(tdResolveDate);
                    row.appendChild(tdResolveComment);

                    // Append the row to the tdBody
                    document.getElementById("requestsTable").appendChild(row);
                }
            }
        }
    };

    // Step 3: Call the open() method
    xhr.open("GET", "/getAllRequests.ajax");

    // Step 4: Call the send() method
    xhr.send();
}

function getIdRequests() {

    // Step 1: create the XMLHttpRequest Object
    let xhr = new XMLHttpRequest();

    // Step 2: Define the onreadystatechange callback function
    xhr.onreadystatechange = function () {
        // Step 5: handle the response
        //console.log(xhr.responseText);
        //console.log(xhr.status);
        if (xhr.readyState === 4 && xhr.status === 200) {

            // Delete the old table body
            let new_tbody = document.createElement("tbody");
            document.getElementById("requestsTable").innerHTML = "";

            let requests = JSON.parse(xhr.responseText);

            let status2 = document.getElementById("statusIdSelect").value;
            let id = document.getElementById("idSelect").value;
            //console.log(status);

            // document.getElementById("eid").value == request.requesterId &&
            for (let request of requests) {

                if (id == request.requesterId && (status2 === "all" || status2 === request.status)) {
                    // Create all the necessary categories
                    let rId = request.rId;
                    let requesterId = request.requesterId;
                    let status = request.status;
                    if (status === "pending") {
                        status = "Pending";
                    }
                    ;
                    if (status === "accepted") {
                        status = "Accepted";
                    }
                    ;
                    if (status === "denied") {
                        status = "Denied";
                    }
                    ;
                    let category = request.category;
                    if (category === "food") {
                        category = "Food";
                    }
                    ;
                    if (category === "lodging") {
                        category = "Lodging";
                    }
                    ;
                    if (category === "travel") {
                        category = "Travel";
                    }
                    ;
                    if (category === "other") {
                        category = "Other";
                    }
                    ;
                    let amount = request.reimbursementAmount;
                    let submitDate = request.submitDate;
                    let submitComment = request.submitComment;
                    let resolveDate = request.resolveDate;
                    let resolveComment = request.resolveComment;

                    // Dynamically create the HTML tags

                    let row = document.createElement("tr");
                    let tdrId = document.createElement("td");
                    let tdRequesterId = document.createElement("td");
                    let tdStatus = document.createElement("td");
                    let tdCategory = document.createElement("td");
                    let tdAmount = document.createElement("td");
                    let tdSubmitDate = document.createElement("td");
                    let tdSubmitComment = document.createElement("td");
                    let tdResolveDate = document.createElement("td");
                    let tdResolveComment = document.createElement("td");

                    // We assign each td their corresponding value
                    tdrId.textContent = rId;
                    tdRequesterId.textContent = requesterId;
                    tdStatus.textContent = status;
                    tdCategory.textContent = category;
                    tdAmount.textContent = amount;
                    tdSubmitDate.textContent = submitDate;
                    tdSubmitComment.textContent = submitComment;
                    tdResolveDate.textContent = resolveDate;
                    tdResolveComment.textContent = resolveComment;

                    // We add each td to the tr
                    row.appendChild(tdrId);
                    row.appendChild(tdRequesterId);
                    row.appendChild(tdStatus);
                    row.appendChild(tdCategory);
                    row.appendChild(tdAmount);
                    row.appendChild(tdSubmitDate);
                    row.appendChild(tdSubmitComment);
                    row.appendChild(tdResolveDate);
                    row.appendChild(tdResolveComment);

                    // Append the row to the tdBody
                    document.getElementById("requestsTable").appendChild(row);
                }
            }
        }
    };

    // Step 3: Call the open() method
    xhr.open("GET", "/getAllRequests.ajax");

    // Step 4: Call the send() method
    xhr.send();
}

function getEmployees() {

    // Step 1: create the XMLHttpRequest Object
    let xhr = new XMLHttpRequest();

    // Step 2: Define the onreadystatechange callback function
    xhr.onreadystatechange = function () {
        // Step 5: handle the response
        //console.log(xhr.responseText);
        //console.log(xhr.status);
        if (xhr.readyState === 4 && xhr.status === 200) {

            // Delete the old table body
            let new_tbody = document.createElement("tbody");
            document.getElementById("requestsTable").innerHTML = "";

            let requests = JSON.parse(xhr.responseText);

            //console.log(status);

            // document.getElementById("eid").value == request.requesterId &&
            for (let request of requests) {

                let eId = request.eId;
                let username = request.username;
                let firstName = request.firstName;
                let lastName = request.lastName;
                let role = request.role;

                let row = document.createElement("tr");
                let tdeId = document.createElement("td");
                let tdUsername = document.createElement("td");
                let tdFirstName = document.createElement("td");
                let tdLastName = document.createElement("td");
                let tdRole = document.createElement("td");

                tdeId.textContent = eId;
                tdUsername.textContent = username;
                tdFirstName.textContent = firstName;
                tdLastName.textContent = lastName;
                tdRole.textContent = role;

                row.appendChild(tdeId);
                row.appendChild(tdUsername);
                row.appendChild(tdFirstName);
                row.appendChild(tdLastName);
                row.appendChild(tdRole);

                // Append the row to the tdBody
                document.getElementById("employeeTable").appendChild(row);
            }
        }

    };

// Step 3: Call the open() method
    xhr.open("GET", "/getAllEmployees.ajax");

// Step 4: Call the send() method
    xhr.send();
}
