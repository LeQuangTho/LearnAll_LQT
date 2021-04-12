using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Bai2_onl.Startup))]
namespace Bai2_onl
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
