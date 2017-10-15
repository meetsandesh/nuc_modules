<html>
    <head>
        <title>CAS</title>
        <link href="/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="/css/docs.css" rel="stylesheet" type="text/css">
        <link href="/css/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="/css/bootstrap-social.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            .hide{
                display: none;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-sm-3">
                <h4>Your Credit Score is:</h4>
                <label style="color: red;">564</label>
            </div>
        </div>
        <div class="row ${(socialCreditScoreModule=='false') ? 'hide' : 'show'}">
            <div class="col-sm-3">
                <h5>Please help us to strengthen your credit profile by granting access to social media apps:</h5>
                <a class="btn btn-block btn-social btn-facebook" onclick="openFBpopup()">
                    <span class="fa fa-facebook"></span> Sign in with Facebook
                </a>
                <a class="btn btn-block btn-social btn-linkedin" onclick="openLinkedInpopup()">
                    <span class="fa fa-linkedin"></span> Sign in with LinkedIn
                </a>
            </div>
        </div>
        <script src="/js/jquery.js"></script>
        <script>
            var fbPopup;
            var linkedInPopup;
            var appId="APP"+(new Date).getTime();
            var name=appId+"_Random_Name";
            var email=appId+"RandomName@gmail.com";
            var mobile="9"+Math.round(Math.random()*1000000000);
            function openFBpopup() {
                fbPopup=window.open('http://localhost:8080/access/facebook?applicationNumber='+appId+'&name='+name+"&email="+email+"&mobile="+mobile, 'Facebook', 'menubar=no,location=no,toolbar=no,scrollbars=yes,resizable=no,top=200,left=200,width=800,height=400');
            }
            function openLinkedInpopup() {
                linkedInPopup=window.open('http://localhost:8080/access/linkedIn?applicationNumber='+appId+'&name='+name+"&email="+email+"&mobile="+mobile, 'Facebook', 'menubar=no,location=no,toolbar=no,scrollbars=yes,resizable=no,top=200,left=200,width=800,height=400');
            }
        </script>
    </body>
</html>

