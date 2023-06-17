<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trapezoid Shape (Reversed)</title>
    <style>
        /* CSS styles here */
        body, html {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            border-radius: 5px;
            padding: 20px;
            background-color: #f2f2f2;
            position: relative;
        }

        svg {
            width: 400px;
            height: 400px;
            display: block;
            margin: 0 auto;
        }

        .stage {
            stroke: white;
            stroke-width: 2px;
        }

        #stage1 {
            fill: #FF7F50; /* Coral */
        }

        #stage2 {
            fill: green; /* Deep Sky Blue */
        }

        #stage3 {
            fill: #FFD700; /* Gold */
        }

        #stage4 {
            fill: #8A2BE2; /* Blue Violet */
        }

        .stage-text {
            font-size: 14px;
            text-anchor: middle;
            dominant-baseline: middle;
            fill: black;
            cursor: pointer;
        }

        .stage-text:hover {
            fill: white;
            background-color: #007BFF; /* Blue */
        }

        .stage-card {
            position: absolute;
            display: none;
            right: -250px; /* Adjust the value as per your requirement */
            top: -50px; /* Adjust the value as per your requirement */
            width: 18rem;
            z-index: 9999;
            background-color: #00BFFF!important;  /* Add your desired background color */
            color: black; /* Add your desired text color */
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('.stage-text').hover(
                function() {
                    var textId = $(this).attr('id');
                    var stagePosition = $(this).prev('.stage').offset();
                    var stageHeight = $(this).prev('.stage').height();
                    var cardId = textId + '-card';
                    var card = $('<div>').addClass('card stage-card').attr('id', cardId);
                    var cardBody = $('<div>').addClass('card-body');
                    var cardTitle = $('<h5>').addClass('card-title').text(textId);
                    var cardText = $('<p>').addClass('card-text').text($(this).data('value'));

                    cardBody.append(cardTitle, cardText);
                    card.append(cardBody);

                    var containerPosition = $('.container').offset();
                    var containerHeight = $('.container').height();
                    var cardOffsetTop = stagePosition.top - containerPosition.top + (stageHeight / 1) - (containerHeight / 1);
                    card.css('top', cardOffsetTop);

                    $('#dynamic-text-fields').append(card).show();
                },
                function() {
                    $('#dynamic-text-fields').empty().hide();
                }
            );
        });
    </script>
</head>
<body>
    <div class="container">
        <svg id="triangular-container" viewBox="0 0 400 400">
            <polygon class="stage" id="stage1" points="0,0 400,0 200,200" />
            <text class="stage-text" x="200" y="50" id="enquiry" data-value="Total Enquiries :(${enquirycount})">Total Enquiries</text>
      
            <polygon class="stage" id="stage2" points="0,100 400,100 200,300" />
            <text class="stage-text" x="200" y="160" id="rfp" data-value="Convert to Rfp's :(${rfpcount})">RFP</text>

            <polygon class="stage" id="stage3" points="0,200 400,200 200,400" />
            <text class="stage-text" x="200" y="250" id="active-rfp" data-value="Active RFP : (${activerfpcount})">Active RFPs</text>

            <polygon class="stage" id="stage4" points="0,300 400,300 200,400" />
            <text class="stage-text" x="200" y="350" id="rfp-complete" data-value=" RFP Approved: (${completerfp})">RFP Completed</text>
        </svg>

        <div id="dynamic-text-fields"></div>
    </div>
</body>
</html>
