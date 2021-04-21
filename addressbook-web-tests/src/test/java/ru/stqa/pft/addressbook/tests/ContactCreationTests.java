package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData()
            .withFirstname("test1").withLastname("test1")
            .withAddress("test 1 - 1").withMobile("+54321")
            .withEmail("test1@mail.ru").withGroup("test1")});
    list.add(new Object[] {new ContactData()
            .withFirstname("test2").withLastname("test2")
            .withAddress("test 2 - 2").withMobile("+54322")
            .withEmail("test2@mail.ru").withGroup("test1")});
    list.add(new Object[] {new ContactData()
            .withFirstname("test3").withLastname("test3")
            .withAddress("test 3 - 3").withMobile("+54323")
            .withEmail("test3@mail.ru").withGroup("test1")});
    return list.iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) throws Exception {
    app.goTo().groupPage();
    Thread.sleep(300);
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("resources/files/photo.jpg");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
