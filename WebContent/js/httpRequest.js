var xhr = null;

function createRequest() {
	
	if( xhr != null ) return;
	
	if( window.ActiveXObject == true ) {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	else {
		xhr = new XMLHttpRequest();
	}
}

function sendRequest( url, param, callBack, method ) {
	createRequest(); // HTTP request 생성
	
	// (1) 전송타입(method) 구분
	var httpMethod = "GET";
	
	if( method == 'POST' || method == 'post' ) {
		httpMethod = "POST";
	}
	
	// (2) 파라미터 구분
	var httpParam = null;
	
	if( param != null && param != '' ) {
		httpParam = param;
	}
	
	// (3) URL
	var httpURL = url;
	
	// (4) 요청 방식이 GET이고, 파라미터가 있다면, url을 직접 만들어줌
	if( httpMethod == 'GET' && httpParam != null ) {
		httpURL = httpURL + "?" + httpParam;
	}
	
	xhr.open( httpMethod, httpURL, true ); // 요청방식, URL, 비동기(true)
	
	// POST라면 반드시 필요한 작업. 요청(request)에 MINE type 설정
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	// 작업이 완료되고, 호출될 콜백함수 지정
	xhr.onreadystatechange = callBack;
	
	// 호출 (GET은 url에 파라미터가 들어있어서 null)
	xhr.send( httpMethod == "POST" ? httpParam : null );
	
}