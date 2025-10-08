package com.mail.dto;


public record MailDTO(String to, String subject, String body) {

}
// if you are not going to change the value once it is set then make the instance variable as final
// once it become final intialize it with the help of constructor or getter/setter.
// if the class has no child class then make the class as final 
// make it as the record