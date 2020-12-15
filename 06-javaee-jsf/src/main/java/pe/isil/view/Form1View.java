package pe.isil.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class Form1View {

    private String text;
    private String password;
    private String message;
    private String hidden="valor oculto";
    private Boolean checked;
    private String oneMenu;
    private String oneRadio;

    private List<String> manyListBox;
    private List<String> manyCheckBox;

    private List<String> availableItems;

    @PostConstruct
    public void init(){
        availableItems = Arrays.asList("One", "Two", "Three");
    }

    public void submit() {
        System.out.println("text= " + text);
        System.out.println("password = " + password);
        System.out.println("message = " + message);
        System.out.println("hidden = " + hidden);
        System.out.println("checked = " + checked);
        System.out.println("oneMenu = " + oneMenu);
        System.out.println("oneRadio = " + oneRadio);
        System.out.println("manyListBox = " + manyListBox);
        System.out.println("manyCheckBox = " + manyCheckBox);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getOneMenu() {
        return oneMenu;
    }

    public void setOneMenu(String oneMenu) {
        this.oneMenu = oneMenu;
    }

    public List<String> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List<String> availableItems) {
        this.availableItems = availableItems;
    }

    public String getOneRadio() {
        return oneRadio;
    }

    public void setOneRadio(String oneRadio) {
        this.oneRadio = oneRadio;
    }

    public List<String> getManyListBox() {
        return manyListBox;
    }

    public void setManyListBox(List<String> manyListBox) {
        this.manyListBox = manyListBox;
    }

    public List<String> getManyCheckBox() {
        return manyCheckBox;
    }

    public void setManyCheckBox(List<String> manyCheckBox) {
        this.manyCheckBox = manyCheckBox;
    }
}
