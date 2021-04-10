package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by coval on 3/26/2021.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getContactHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContactToEdit()){
      app.getContactHelper().createContact(new ContactData(
              "Test",
              "Test",
              "Test 1 - 2",
              "+5252525",
              "test@mail.ru",
              "test1"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().editContact(before - 1);
    app.getContactHelper().fillContactForm(new ContactData(
            "Test1",
            "Test2",
            "Test 1 - 233",
            "+3725353535353",
            "test1@mail.ru",
            null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
