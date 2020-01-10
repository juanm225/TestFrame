package lights.dev.Config;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static lights.dev.Config.DriverType.valueOf;
import static lights.dev.Config.DriverType.FIREFOX;

public class DriverFactory {
    private RemoteWebDriver webDriver;
    private DriverType selectedDriverType;

    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");

    public DriverFactory()
    {
        DriverType drivertype = FIREFOX;
        String browser = System.getProperty("browser", drivertype.toString()).toUpperCase();
        try
        {
            drivertype = valueOf(browser);
        }
        catch(IllegalArgumentException ignored)
        {
            System.err.println("Unknow driver expecified, defaulting to '"+drivertype+"'...");
        }
        catch(NullPointerException ignored)
        {
            System.err.println("No driver expecified, defaulting to '"+drivertype+"'...");
        }
        selectedDriverType = drivertype;
    }

    public RemoteWebDriver getDriver()
    {
        if(null == webDriver)
        {
            instantiateWebDriver (selectedDriverType);
        }
        return webDriver;
    }

    public void quitDriver()
    {
        if(null != webDriver)
        {
            webDriver.quit();
            webDriver = null;
        }
    }

    public void instantiateWebDriver(DriverType drivertype)
    {
        System.out.println(" ");
        System.out.println("Local Operating system: "+operatingSystem);
        System.out.println("Local Architecture: "+systemArchitecture);
        System.out.println("Selected Browser: "+selectedDriverType);
        System.out.println(" ");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        webDriver = drivertype.getWebDriverObject(desiredCapabilities);
    }
}
