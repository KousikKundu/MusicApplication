import { AppPage } from './app.po';
import { browser, by , element} from 'protractor';


describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display title of application', () => {
    page.navigateTo();
    expect(browser.getTitle()).toEqual('MuzixUI');
  });

  it('should be redirected to /login route', () => {
    browser.element(by.css('.register-button')).click();
    expect(browser.getCurrentUrl()).toContain('/register');
    browser.driver.sleep(2000);
  });

  it('should be able to register user', () => {
    browser.element(by.id('username')).sendKeys("kousik");
    browser.element(by.id('email')).sendKeys("kousik");
    browser.element(by.id('password')).sendKeys("kousik");
    browser.element(by.css('.register-user')).click();
    browser.driver.sleep(2000);
  });

 
  it('should be able to login user', () => {
    browser.element(by.id('username')).sendKeys("kousik");
    browser.element(by.id('password')).sendKeys("kousik");
    browser.element(by.css('.login-button')).click();
    browser.driver.sleep(2000);
  });


  it('should be able to save Indian track to playlist ', () => {
    browser.driver.manage().window().maximize();
    browser.driver.sleep(1000);
    const tracks = element.all(by.css('.example-card'));
    browser.element(by.css('.addbutton')).click();
    browser.driver.sleep(1000);
  });

  it('should be able get all tracks from playlist', () => {
    browser.driver.sleep(1000);
    browser.element(by.css('.mat-btn-wishlist')).click();
    browser.driver.sleep(1000);
    expect(browser.getCurrentUrl()).toContain('/wishList');
    browser.driver.sleep(1000);
  });

  it('should be able to open dialouge box to update comments ', () => {
    browser.driver.sleep(1000);
    const tracks = element.all(by.css('.example-card'));
    browser.element(by.css('.updatebutton')).click();
    browser.driver.sleep(1000);
  });

  it('should be able to save updated user from wishlist', () => {
    browser.driver.sleep(1000);
    browser.element(by.css('.matInput')).sendKeys("New Comments");
    browser.driver.sleep(1000);
    browser.element(by.css('.updateCommentDemo')).click();
    browser.driver.sleep(2000);
  });

  it('should be able to logout user', () => {
    browser.driver.sleep(1000);
    browser.element(by.css('.mat-btn-logout')).click();
    browser.driver.sleep(1000);
  });

  
});
