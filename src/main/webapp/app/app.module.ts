import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { JhCrawlSharedModule } from 'app/shared/shared.module';
import { JhCrawlCoreModule } from 'app/core/core.module';
import { JhCrawlAppRoutingModule } from './app-routing.module';
import { JhCrawlHomeModule } from './home/home.module';
import { JhCrawlEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    JhCrawlSharedModule,
    JhCrawlCoreModule,
    JhCrawlHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    JhCrawlEntityModule,
    JhCrawlAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class JhCrawlAppModule {}
