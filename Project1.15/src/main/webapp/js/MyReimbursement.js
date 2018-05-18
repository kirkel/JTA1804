window.onload = function(){
    document.getElementById("getRequests").addEventListener("click", getRequests);
    getRequests();
}

function getRequests(){

    // Step 1: create the XMLHttpRequest Object
    let xhr = new XMLHttpRequest();

    // Step 2: Define the onreadystatechange callback function
    xhr.onreadystatechange = function(){
        // Step 5: handle the response
        //console.log(xhr.responseText);
        //console.log(xhr.status);
        if(xhr.readyState === 4 && xhr.status === 200){

            // Delete the old table body
            let new_tbody = document.createElement("tbody");
            document.getElementById("requestsTable").innerHTML = "";

            let requests = JSON.parse(xhr.responseText);

            let status = document.getElementById("requestSelector").value;
            //console.log(status);


            for (let request of requests){

                if (document.getElementById("eid").value == request.requesterId && (status === "all" ||  status === request.status )){
                    // Create all the necessary categories
                    let category = request.category;
                    if (category === "food"){category = "Food";};
                    if (category ==="lodging"){category = "Lodging";};
                    if (category === "travel"){category = "Travel";};
                    if (category === "other"){category = "Other";};
                    let status = request.status;
                    if (status === "pending"){status = "Pending";};
                    if (status === "accepted"){status = "Accepted";};
                    if (status === "denied"){status = "Denied";};
                    let amount = request.reimbursementAmount;
                    let message = request.submitComment;
                    let date = request.submitDate;
                    let resolveDate = request.resolveDate;
                    let resolveComment = request.resolveComment;

                    // Dynamically create the HTML tags
                    let row = document.createElement("tr");
                    let tdStatus = document.createElement("td");
                    let tdCategory = document.createElement("td");
                    let tdAmount = document.createElement("td");
                    let tdMessage = document.createElement("td");
                    let tdDate = document.createElement("td");
                    let tdResolveDate = document.createElement("td");
                    let tdResolveComment = document.createElement("td");


                    // We assign each td their corresponding value
                    tdCategory.textContent = category;
                    tdStatus.textContent = status;
                    tdAmount.textContent = amount;
                    tdMessage.textContent = message;
                    tdDate.textContent = date;
                    tdResolveDate.textContent = resolveDate;
                    tdResolveComment.textContent = resolveComment;

                    // We add each td to the tr
                    row.appendChild(tdStatus);
                    row.appendChild(tdCategory);
                    row.appendChild(tdAmount);
                    row.appendChild(tdMessage);
                    row.appendChild(tdDate);
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
