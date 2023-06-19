<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Download File</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    function getFile() {
      $.ajax({
        url: 'getfile',
        method: 'GET',
        xhrFields: {
          responseType: 'blob' // Set the response type to 'blob' to handle binary data
        },
        success: function(data, textStatus, xhr) {
          // Extract the filename from the 'Content-Disposition' header
          var filename = '';
          var disposition = xhr.getResponseHeader('Content-Disposition');
          if (disposition && disposition.indexOf('attachment') !== -1) {
            var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
            var matches = filenameRegex.exec(disposition);
            if (matches != null && matches[1]) {
              filename = matches[1].replace(/['"]/g, '');
            }
          }

          // Create a temporary anchor element to trigger the file download
          var anchor = document.createElement('a');
          var url = window.URL.createObjectURL(data);
          anchor.href = url;
          anchor.download = filename;

          // Simulate a click on the anchor element to start the download
          document.body.appendChild(anchor);
          anchor.click();

          // Clean up the temporary URL and anchor element
          document.body.removeChild(anchor);
          window.URL.revokeObjectURL(url);
        },
        error: function(xhr, textStatus, errorThrown) {
          // Handle the error case
          console.error('Error: ' + errorThrown);
        }
      });
    }
  </script>
</head>
<body>
  <h1>Download File</h1>
  <button onclick="getFile()">Download</button>
</body>
</html>
