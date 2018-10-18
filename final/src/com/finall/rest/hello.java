package com.finall.rest;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.finall.dao.AddEntry;

@Path("/path1")
public class hello {
	
	@POST
	@Path("/path2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public String myMethod(String qe) throws ClassNotFoundException, SQLException, ParseException {
		
		System.out.println(qe + " input from ui");
		
		JSONParser jp = new JSONParser();
		JSONObject jo1 = (JSONObject) jp.parse(qe);
		
		AddEntry add = new AddEntry();
		String msg = add.addInStudent((long) jo1.get("id"),(String)jo1.get("value"));
		System.out.println(msg);
		
		return qe;
	}
}
