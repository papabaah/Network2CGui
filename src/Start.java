import com.networkc.model.Formula;
import com.networkc.model.Rectangle;
import com.networkc.util.DBAccess;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Start {

  static DBAccess dao = new DBAccess();

  public static void main(String[] args) {
    try {
      delete(8);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void createRectangle() throws Exception {

    double len = 189;
    double hei = 50;
    double res = 0;
    Formula formula = Formula.PERIMETER;

    switch (formula){
      case AREA:
        res = len * hei;
        break;
      case PERIMETER:
        res = 2 * (len + hei);
        break;
    }
    Timestamp datec = new Timestamp(new Date().getTime());

    Rectangle rect = new Rectangle();
    rect.setLength(len);
    rect.setHeight(hei);
    rect.setResult(res);
    rect.setFormula(formula);
    rect.setDateCreated(datec);
    dao.save(rect);
  }

  public static void selectAll() throws Exception {

    List<Rectangle> listRec = dao.findAll();
    for(Rectangle rec : listRec)
      System.out.println(rec.toString());
  }

  public static void delete(int id) throws SQLException {
    int count = dao.delete(id);
    System.out.println("After Delete: count is " + count);
  }

}

