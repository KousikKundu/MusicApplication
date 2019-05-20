package com.stackroute.muzixmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "User already existsTrackAlreadyExistsException\n" +
  "TrackNotFoundException")
public class UserAlreadyExistsException extends  Exception{
}
