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
            window.location.href = `${urlPrefix}?id=` + id;
        });
    });
}