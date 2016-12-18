package pro.lesson1;

/**
 * Created by Bohdan on 17.12.2016.
 */
public class User
{
    private String login;
    private String password;
    private int year;

    public User(String login, String password, int year)
    {
        this.login = login;
        this.password = password;
        this.year = year;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (object != null && getClass().equals(object.getClass()))
        {
            User user = (User) object;

            if (!login.equals(user.login))
            {
                return false;
            }

            if (!password.equals(user.password))
            {
                return false;
            }

            if (year != user.year)
            {
                return false;
            }

            return true;
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return login.hashCode() * password.hashCode() * year * 31;
    }
}
