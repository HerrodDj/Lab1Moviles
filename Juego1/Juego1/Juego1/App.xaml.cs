using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using Juego1.Services;
using Juego1.Views;

namespace Juego1
{
    public partial class App : Application
    {

        public App()
        {
            InitializeComponent();

            DependencyService.Register<MockDataStore>();
            MainPage = new MainPage();
        }

        protected override void OnStart()
        {
        }

        protected override void OnSleep()
        {
        }

        protected override void OnResume()
        {
        }
    }
}
