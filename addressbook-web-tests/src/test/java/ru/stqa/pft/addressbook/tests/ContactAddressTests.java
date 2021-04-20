package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase{

  @Test
  public void ensurePreconditions(){
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
  public void testContactAddresses() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

//    assertThat(contact.getAllAddresses(), equalTo(mergeAddresses(contactInfoFromEditForm)));
    assertThat(contact.getAllAddresses(), equalTo(mergeAddresses(contactInfoFromEditForm)));
  }

  private String mergeAddresses(ContactData contact) {
    return Arrays.asList(contact.getAddress())
            .stream()
            .map(ContactAddressTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String address){
    return address.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
