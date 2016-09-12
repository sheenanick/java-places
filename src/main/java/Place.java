import java.util.Date;

public class Place {
  private String mCountry;
  private String mCity;
  private String mMainAttraction;
  private Date mDate;


  public Place (String country, String city, String mainAttraction, Date date) {
    mCountry = country;
    mCity = city;
    mMainAttraction = mainAttraction;
    mDate = date;
  }

  public String getCountry() {
    return mCountry;
  }

  public String getCity() {
    return mCity;
  }

  public String getMainAttraction() {
    return mMainAttraction;
  }

  public Date getDate() {
    return mDate;
  }

}
