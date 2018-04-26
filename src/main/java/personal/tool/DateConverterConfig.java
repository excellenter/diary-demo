package personal.tool;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DateConverterConfig implements Converter<String, Date> {

    private static final List<String> formats = new ArrayList<>(4);

    static {
        formats.add("yyyy-MM");
        formats.add("yyyy-MM-dd");
        formats.add("yyyy-MM-dd hh:mm");
        formats.add("yyyy-MM-dd hh:mm:ss");
    }

    public Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {

        }
        return date;
    }

    @Override
    public Date convert(String s) {
        String value = s.trim();
        if ("".equals(value)) {
            return null;
        }
        if (s.matches("^\\d{4}-\\d{1,2}$")) {
            return parseDate(s, formats.get(0));
        } else if (s.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return parseDate(s, formats.get(1));
        } else if (s.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            return parseDate(s, formats.get(2));
        } else if (s.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return parseDate(s, formats.get(3));
        } else {
            throw new IllegalArgumentException("不正确的日期格式: '" + s + "'");
        }
    }
}
