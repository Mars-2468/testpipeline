<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Real-Time Error Message</title>
    <link rel="stylesheet" href="styles.css">
	<style>

body {
    font-family: 'Arial', sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    background-color: #f0f0f0;
}

.container {
    background-color: white;
    padding: 40px;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

#errorContainer {
    background-color: #ffdddd;
    color: #d8000c;
    border: 2px solid #d8000c;
    padding: 20px;
    border-radius: 5px;
    text-align: center;
}

#errorContainer p {
    font-size: 2em; /* Larger font size */
    font-weight: bold;
    margin: 0;
}

.error-code {
    font-size: 1.5em; /* Slightly smaller than main message */
    display: block;
    margin-bottom: 10px;
    color: #b30000;
}

	</style>
</head>
<body>
    <div class="container">
        <div id="errorContainer">
<p><span class="error-code">405</span> Form submission failed.</p>
        </div>
    </div>
</body>
</html>
