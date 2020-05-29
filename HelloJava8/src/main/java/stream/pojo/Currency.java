package stream.pojo;

/**
 * Created by yh on 9/6/18.
 */
public class Currency {

    private String name;

    public Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Currency) obj).getName().equalsIgnoreCase(this.name);
    }
}
