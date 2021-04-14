package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by coval on 3/26/2021.
 */
public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
    app.contact().home();
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData()
              .withFirstname("Test8").withLastname("Test").withAddress("Test 1 - 2")
              .withMobile("+5252525").withEmail("test@mail.ru")
              .withGroup("test1"), true);
    }
  }

  @Test
  public void testContactDeletion() throws InterruptedException {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    Thread.sleep(100);
    app.contact().home();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
      Assert.assertEquals(before, after);
  }

}
