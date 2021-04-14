package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().groupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupData("test1", null, null));
    }
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData(
            "Test8",
            "Test",
            "Test 1 - 2",
            "+5252525",
            "test@mail.ru",
            "test1");
    app.contact().create(contact, true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
