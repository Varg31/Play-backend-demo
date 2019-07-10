package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class MainController extends Controller {

    public Result index() {
        return ok("Main page");
    }

    public Result hello(String text) {
        return ok("Hello " + text);
    }
}
