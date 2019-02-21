$(document).ready(function() {
	// 自身要写的jQuery代码
	"use strict";

	var select = document.getElementsByTagName('select');
	var title = $(select).attr("title");

	switch (title) {
	case "Tesla Model S":
		$(select).val("Tesla Model S");
		break;
	case "Tesla Model X":
		$(select).val("Tesla Model X");
		break;
	case "Tesla Model 3":
		$(select).val("Tesla Model 3");
		break;
	case "Tesla RoadSter":
		$(select).val("Tesla RoadSter");
		break;
	}
	
});
