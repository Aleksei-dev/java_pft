package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by coval on 3/26/2021.
 */
public class ContactDeletionTests extends TestBase {

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
  public void testContactDeletion() throws InterruptedException {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Thread.sleep(200);
    app.contact().home();
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
