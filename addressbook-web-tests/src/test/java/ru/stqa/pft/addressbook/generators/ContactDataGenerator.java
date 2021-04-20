package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++){
      contacts.add(new ContactData()
              .withFirstname(String.format("TestName%s", i))
              .withLastname(String.format("TestLastname%s", i))
              .withAddress(String.format("TestAddress - 3%s", i))
              .withMobile(String.format("+5434245%s", i))
              .withEmail(String.format("test%s@mail.ru", i))
              .withGroup(String.format("test1")));
    }
    return contacts;
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsoluteFile());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts){
      writer.write(String.format("%s;%s;%s;%s;%s;%s\n",
              contact.getFirstname(),
              contact.getLastname(),
              contact.getAddress(),
              contact.getMobile(),
              contact.getEmail(),
              contact.getGroup()));
    }
    writer.close();
  }
}
