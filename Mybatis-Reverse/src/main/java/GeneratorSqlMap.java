

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlMap {

	public static void main(String[] args) throws Exception {
		try {
			GeneratorSqlMap generatorSqlmap = new GeneratorSqlMap();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *@information 自动生成mapper,pojo,mapper.xml
	 *@author xiaomao
	 *@param
	 *@return void
	 *@date 2021/3/25 0025 08:45
	 *@throws
	 */
	public void generator() throws Exception{

		List<String> warnings = new ArrayList<String>();
		//boolean overWrite = true;
		File configFile = new File("C:\\Users\\Administrator\\Documents\\GitHub\\notes_javautils\\Mybatis-Reverse\\src\\main\\resources\\generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

	}

}
