package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

/**
 * Created by coval on 3/26/2021.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
    app.contact().home();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData()
              .withFirstname("Test8").withLastname("Test").withAddress("Test 1 - 2")
              .withMobile("+5252525").withEmail("test@mail.ru")
              .withGroup("test1"), true);
    }
  }

  @Test
  public void testContactModification(){
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Test8")
            .withLastname("Test").withAddress("Test 1 - 2")
            .withMobile("+5252525").withEmail("test@mail.ru")
            .withGroup("test1");
    app.contact().modifyContact(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
