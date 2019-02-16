package Controller;

import Model.ResponseBO;
import Parsers.JSONParser;
import Utils.HTTPURLConnectionHelper;

public class LiveDataProvider {
    public ResponseBO getServerData() {
        HTTPURLConnectionHelper httpurlConnectionHelper = new HTTPURLConnectionHelper();
        String response = httpurlConnectionHelper.makeServiceCall();
        JSONParser jsonParser = new JSONParser();
        ResponseBO responseBO = new ResponseBO();
        responseBO.setMovieArrayList(jsonParser.parseData(response));
        return responseBO;
    }
}
