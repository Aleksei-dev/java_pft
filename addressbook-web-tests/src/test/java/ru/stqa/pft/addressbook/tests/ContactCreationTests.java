package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().groupPage();
    Thread.sleep(300);
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("resources/files/photo.jpg");
    ContactData contact = new ContactData()
            .withFirstname("Test8")
            .withLastname("Test")
//            .withPhoto(photo)
            .withAddress("Test 1 - 2")
            .withMobile("+5252525")
            .withEmail("test@mail.ru")
            .withGroup("test1");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
