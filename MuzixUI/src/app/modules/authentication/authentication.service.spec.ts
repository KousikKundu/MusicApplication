import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { AuthenticationService } from './authentication.service';


const testData= {
  userName: "test",
  password: "test",
  email:"test@test.com"
}
describe('AuthenticationService', () => {
  let authService: AuthenticationService;
  let httpTestingController: HttpTestingController;
  const testForRegister = "http://localhost:8086/usertrackservice/api/usertrackservice/register";
  const testForLogin = "http://localhost:8086/authenticationservice/api/userservice/login";
  beforeEach(() => {

  TestBed.configureTestingModule({
    imports: [HttpClientTestingModule],
    providers: [AuthenticationService]
  })
  authService = TestBed.get(AuthenticationService);
  httpTestingController = TestBed.get(HttpTestingController);
});

  it('should be created', () => {
    //const service: AuthenticationService = TestBed.get(AuthenticationService);
    expect(authService).toBeTruthy();
  });

  it('register user should fetch proper response from http call',() => {

    authService.registerUser(testData).subscribe(result =>{
      console.log(result);
      expect(result.body).toBe(testData);
    });

    const httpMockReq = httpTestingController.expectOne(testForRegister);
    expect(httpMockReq.request.method).toBe('POST');
    expect(httpMockReq.request.url).toEqual(testForRegister);

  });

  it('login user should fetch proper response from http call',() => {

    authService.loginUser(testData).subscribe(result =>{
      console.log(result);
      expect(result.body).toBe(testData);
    });

    const httpMockReq = httpTestingController.expectOne(testForLogin);
    expect(httpMockReq.request.method).toBe('POST');
    expect(httpMockReq.request.url).toEqual(testForLogin);

  });

});
