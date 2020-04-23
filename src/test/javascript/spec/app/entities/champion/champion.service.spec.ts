import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ChampionService } from 'app/entities/champion/champion.service';
import { IChampion, Champion } from 'app/shared/model/champion.model';

describe('Service Tests', () => {
  describe('Champion Service', () => {
    let injector: TestBed;
    let service: ChampionService;
    let httpMock: HttpTestingController;
    let elemDefault: IChampion;
    let expectedResult: IChampion | IChampion[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ChampionService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new Champion(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a Champion', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new Champion()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Champion', () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            faction: 'BBBBBB',
            rarity: 'BBBBBB',
            affinity: 'BBBBBB',
            role: 'BBBBBB',
            rank: 'BBBBBB',
            viewPageUrl: 'BBBBBB',
            fusion: 'BBBBBB',
            equipmentA: 'BBBBBB',
            equipmentB: 'BBBBBB',
            equipmentStatPriorityA: 'BBBBBB',
            equipmentStatPriorityB: 'BBBBBB',
            tier: 1,
            healthPoints: 1,
            attack: 1,
            defense: 1,
            speed: 1,
            criticalRate: 1,
            criticalDamage: 1,
            resistance: 1,
            accuracy: 1,
            campaignRating: 1,
            factionWarRating: 1,
            arenaOffenseRating: 1,
            arenaDefenseRating: 1,
            iceGolemRating: 1,
            spidersDenRating: 1,
            minotaursLabyrinthRating: 1,
            dragonsLairRating: 1,
            fireKnightsCastleRating: 1,
            voidKeepRating: 1,
            spiritKeepRating: 1,
            magicKeepRating: 1,
            forceKeepRating: 1
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of Champion', () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            faction: 'BBBBBB',
            rarity: 'BBBBBB',
            affinity: 'BBBBBB',
            role: 'BBBBBB',
            rank: 'BBBBBB',
            viewPageUrl: 'BBBBBB',
            fusion: 'BBBBBB',
            equipmentA: 'BBBBBB',
            equipmentB: 'BBBBBB',
            equipmentStatPriorityA: 'BBBBBB',
            equipmentStatPriorityB: 'BBBBBB',
            tier: 1,
            healthPoints: 1,
            attack: 1,
            defense: 1,
            speed: 1,
            criticalRate: 1,
            criticalDamage: 1,
            resistance: 1,
            accuracy: 1,
            campaignRating: 1,
            factionWarRating: 1,
            arenaOffenseRating: 1,
            arenaDefenseRating: 1,
            iceGolemRating: 1,
            spidersDenRating: 1,
            minotaursLabyrinthRating: 1,
            dragonsLairRating: 1,
            fireKnightsCastleRating: 1,
            voidKeepRating: 1,
            spiritKeepRating: 1,
            magicKeepRating: 1,
            forceKeepRating: 1
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a Champion', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
