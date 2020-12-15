package pe.isil.view;

import pe.isil.model.Customer;
import pe.isil.service.CustomerService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class Form2View {
    private String documentType;

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String documentNumber;

    private List<String> documentTypeList;
    private List<String> genderList;
    private List<Customer> customerList;

    @Inject
    private CustomerService customerService;

    @PostConstruct
    public void init() {
        documentTypeList = Arrays.asList("DNI", "C.E");
        genderList = Arrays.asList("Male", "Female");
        customerList = customerService.getAll();
    }

    public void submit() throws IOException {
        System.out.println("*****************************");
        Customer customer = new Customer(null, documentType, documentNumber, firstName, lastName, email, gender);
        customerService.create(customer);
        System.out.println("customer = " + customer);

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath()+"/Table.xhtml");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getDocumentTypeList() {
        return documentTypeList;
    }

    public void setDocumentTypeList(List<String> documentTypeList) {
        this.documentTypeList = documentTypeList;
    }

    public List<String> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<String> genderList) {
        this.genderList = genderList;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }


}
