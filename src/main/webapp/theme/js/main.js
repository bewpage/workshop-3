document.addEventListener("DOMContentLoaded", function () {
    console.log("DOM fully loaded and parsed");
    // call editUser function
    actionButtons("#edit_btn");

    // call deleteUser function
    actionButtons("#delete_btn");

    // show user info function
    actionButtons("#show_btn");
});

/**
 * Edit user function to redirect to edit page
 */
function actionButtons(btnSelector) {
    // select button in table
    const editBtns = document.querySelectorAll(btnSelector);
    const match = btnSelector.match(/#(\w+)_/);
    const urlPrefix = match ? match[1] : "";

    // add event listener to each edit button
    editBtns.forEach(btn => {
        btn.addEventListener("click", function () {
            // get id of the row
            const id = btn.parentNode.parentNode.parentNode.querySelector("td:nth-child(1)").innerText;
            console.log(id);
            // redirect to edit page
            console.log(btnSelector.match(/#(\w+)_/)[1]);
            if (urlPrefix === "delete") {
                const confirmDeleteBtn = document.querySelector("#confirmDeleteBtn");
                confirmDeleteBtn.addEventListener("click", async function () {
                    console.log("confirm delete");
                    console.log(`${urlPrefix}?id=` + id);
                    confirmDeleteBtn.setAttribute("data-dismiss", "modal");
                    await fetch(`${urlPrefix}?id=${id}`, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({id: id})
                    }).then(response => {
                        console.log(response.status);
                        if (response.status === 200) {
                            window.location.href = `list`;
                        } else {
                            console.log("error");
                            window.alert("Delete failed");
                        }
                    }).catch(error => {
                        console.log(error);
                    });
                })

            } else {
                window.location.href = `${urlPrefix}?id=` + id;
            }
        });
    });
}