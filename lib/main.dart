import 'dart:convert';
import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      debugShowCheckedModeBanner: false,
      home: new FormPage(),
    );
  }
}

class FormPage extends StatefulWidget {
  @override
  _FormPageState createState() => new _FormPageState();
}

class _FormPageState extends State<FormPage> {
  String _email = "";
  String _password = "";

  //////////////////////////////////////////////////////////////
  sendLogInRequest() async {
    Map data = {"email": _email, "password": _password};

    final response =
        await http.post("url_here",
            headers: {
              HttpHeaders.authorizationHeader: "your_api_token_here",
              'Content-type': 'application/json',
            },
            body: jsonEncode(data));

    if (response.statusCode == 201) {
      //return jsonDecode(response.body);
      print("success");
    } else {
      print("failed log in");
    }
  }
  /////////////////////////////////////////////////////////////////

  letsGetStartedTextConfig() {
    return Container(
      child: Stack(
        children: <Widget>[
          Container(
            padding: EdgeInsets.fromLTRB(10, 140, 0, 0),
            child: Text(
              "LET'S GET\nSTARTED",
              style: TextStyle(
                  fontSize: 60,
                  fontFamily: "LaranjhaLight",
                  fontWeight: FontWeight.bold,
                  color: Color(0xffE4E4E4)),
            ),
          )
        ],
      ),
    );
  }

  emailTextFieldConfig() {
    return TextField(
      onTap: ,
      onChanged: (text) => _email = text,
      textAlign: TextAlign.center,
      cursorColor: Color(0xff464950),
      style: TextStyle(color: Color(0xff464950)),
      decoration: InputDecoration(
        enabledBorder: UnderlineInputBorder(
            borderSide: BorderSide(color: Color(0xff8F95A3))),
        focusedBorder: UnderlineInputBorder(
            borderSide: BorderSide(color: Color(0xff000000))),
        labelText: "email",
        labelStyle: TextStyle(
            fontSize: 21, fontFamily: "GothamPro", color: Color(0xff6E6E6E)),
      ),
    );
  }

  passwordTextFieldConfig() {
    return TextField(
      onChanged: (text) => _password = text,
      textAlign: TextAlign.center,
      cursorColor: Color(0xff464950),
      style: TextStyle(color: Color(0xff464950)),
      obscureText: true,
      decoration: InputDecoration(
        enabledBorder: UnderlineInputBorder(
            borderSide: BorderSide(color: Color(0xff8F95A3))),
        focusedBorder: UnderlineInputBorder(
            borderSide: BorderSide(color: Color(0xff000000))),
        labelText: "password",
        labelStyle: TextStyle(
            fontSize: 21, fontFamily: "GothamPro", color: Color(0xff6E6E6E)),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      resizeToAvoidBottomPadding: false,
      body: Container(
        decoration: BoxDecoration(
            image: DecorationImage(
                image: AssetImage("assets/images/login_form.png"),
                fit: BoxFit.cover)),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            letsGetStartedTextConfig(),
            Container(
              padding: EdgeInsets.only(top: 150, left: 60, right: 60),
              child: Column(
                children: <Widget>[
                  emailTextFieldConfig(),
                  passwordTextFieldConfig(),
                  SizedBox(height: 40),
                  Container(
                    padding: EdgeInsets.only(top: 30, left: 10, right: 10),
                    height: 90,
                    child: Material(
                      borderRadius: BorderRadius.circular(20),
                      color: Color(0xffFE862C),
                      child: GestureDetector(
                        onTap: () => sendLogInRequest(),
                        child: Center(
                          child: Text(
                            "Log in",
                            style: TextStyle(
                              fontSize: 21,
                              fontFamily: "GothamPro",
                              color: Color(0xffFFFFFF),
                            ),
                          ),
                        ),
                      ),
                    ),
                  ),
                  SizedBox(height: 20)
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}
