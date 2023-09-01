<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        $("form").submit(function(event) {
            var userID = $("input[name='userID']").val();
            var password = $("input[name='password']").val();

            if (userID === "" || password === "") {
                alert("Please fill in all fields.");
                event.preventDefault();
            }
        });
    });
</script>
