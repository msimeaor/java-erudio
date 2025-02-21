package br.com.msimeaor.java.erudio.exceptions;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String description, String details) { }
