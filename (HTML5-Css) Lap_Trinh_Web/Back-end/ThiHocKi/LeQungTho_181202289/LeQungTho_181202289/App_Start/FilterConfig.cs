using System.Web;
using System.Web.Mvc;

namespace LeQungTho_181202289
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
